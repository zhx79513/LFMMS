-- Database: "League Football Matches Manage System"

-- DROP DATABASE "League Football Matches Manage System";

CREATE DATABASE "League Football Matches Manage System"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Chinese (Simplified)_People''s Republic of China.936'
       LC_CTYPE = 'Chinese (Simplified)_People''s Republic of China.936'
       CONNECTION LIMIT = -1;

COMMENT ON DATABASE "League Football Matches Manage System"
  IS '足球联赛管理系统';

  
  
  
-- Table: team

-- DROP TABLE team;

CREATE TABLE team
(
  id serial NOT NULL, -- 球队ID
  name character varying(20) NOT NULL, -- 球队名称
  home character varying(30) NOT NULL, -- 球队主场
  coach character varying(20) NOT NULL, -- 主教练
  CONSTRAINT team_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE team
  OWNER TO postgres;
COMMENT ON TABLE team
  IS '球队表';
COMMENT ON COLUMN team.id IS '球队ID';
COMMENT ON COLUMN team.name IS '球队名称';
COMMENT ON COLUMN team.home IS '球队主场';
COMMENT ON COLUMN team.coach IS '主教练';

GRANT SELECT(id), REFERENCES(id) ON team TO public;









-- Table: player

-- DROP TABLE player;

CREATE TABLE player
(
  id serial NOT NULL, -- 球员ID
  name character varying(20) NOT NULL, -- 球员姓名
  team_id integer NOT NULL, -- 球队ID
  "number" smallint NOT NULL, -- 球衣号码
  "position" smallint NOT NULL, -- 场上位置，0守门员，1后卫，2中场，3前锋
  height smallint, -- 球员身高
  weight smallint, -- 球员体重
  birthday date, -- 球员生日
  CONSTRAINT player_pkey PRIMARY KEY (id),
  CONSTRAINT player_team_id_fkey FOREIGN KEY (team_id)
      REFERENCES team (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT player_position_check CHECK ("position" >= 0 AND "position" <= 3)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE player
  OWNER TO postgres;
COMMENT ON TABLE player
  IS '球员表';
COMMENT ON COLUMN player.id IS '球员ID';
COMMENT ON COLUMN player.name IS '球员姓名';
COMMENT ON COLUMN player.team_id IS '球队ID';
COMMENT ON COLUMN player."number" IS '球衣号码';
COMMENT ON COLUMN player."position" IS '场上位置，0守门员，1后卫，2中场，3前锋';
COMMENT ON COLUMN player.height IS '球员身高';
COMMENT ON COLUMN player.weight IS '球员体重';
COMMENT ON COLUMN player.birthday IS '球员生日';

GRANT SELECT(id), REFERENCES(id) ON player TO public;










-- Table: course

-- DROP TABLE course;

CREATE TABLE course
(
  id serial NOT NULL, -- 比赛ID
  home_id smallint NOT NULL, -- 主场球队ID
  away_id smallint NOT NULL, -- 客场球队ID
  turn smallint NOT NULL, -- 比赛轮次
  match_date timestamp with time zone NOT NULL, -- 比赛日期
  home_score smallint NOT NULL, -- 主队比分
  away_score smallint NOT NULL, -- 客队比分
  CONSTRAINT "Course_pkey" PRIMARY KEY (id),
  CONSTRAINT "Course_Away_ID_fkey" FOREIGN KEY (away_id)
      REFERENCES team (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Course_Home_ID_fkey" FOREIGN KEY (home_id)
      REFERENCES team (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE course
  OWNER TO postgres;
COMMENT ON TABLE course
  IS '比赛进程表';
COMMENT ON COLUMN course.id IS '比赛ID';
COMMENT ON COLUMN course.home_id IS '主场球队ID';
COMMENT ON COLUMN course.away_id IS '客场球队ID';
COMMENT ON COLUMN course.turn IS '比赛轮次';
COMMENT ON COLUMN course.match_date IS '比赛日期';
COMMENT ON COLUMN course.home_score IS '主队比分';
COMMENT ON COLUMN course.away_score IS '客队比分';

GRANT SELECT(id), REFERENCES(id) ON course TO public;







-- Table: goal

-- DROP TABLE goal;

CREATE TABLE goal
(
  id serial NOT NULL, -- 进球ID
  course_id integer NOT NULL, -- 比赛ID
  player_id integer NOT NULL, -- 球员ID
  goal_time timestamp with time zone NOT NULL, -- 进球时间
  CONSTRAINT "Goal_pkey" PRIMARY KEY (id),
  CONSTRAINT "Goal_Course_ID_fkey" FOREIGN KEY (course_id)
      REFERENCES course (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Goal_Player_ID_fkey" FOREIGN KEY (player_id)
      REFERENCES player (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE goal
  OWNER TO postgres;
COMMENT ON TABLE goal
  IS '进球表';
COMMENT ON COLUMN goal.id IS '进球ID';
COMMENT ON COLUMN goal.course_id IS '比赛ID';
COMMENT ON COLUMN goal.player_id IS '球员ID';
COMMENT ON COLUMN goal.goal_time IS '进球时间';

GRANT SELECT(id), REFERENCES(id) ON goal TO public;





-- Function: team_rank_calc_net_goal_trigger()

-- DROP FUNCTION team_rank_calc_net_goal_trigger();

CREATE OR REPLACE FUNCTION team_rank_calc_net_goal_trigger()
  RETURNS trigger AS
$BODY$BEGIN
UPDATE Team_Rank SET Net_Goal = NEW.Goal - NEW.Lost_Goal;
RETURN NEW;
END;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION team_rank_calc_net_goal_trigger()
  OWNER TO postgres;
COMMENT ON FUNCTION team_rank_calc_net_goal_trigger() IS '计算team_rank表的净胜球';





-- Table: team_rank

-- DROP TABLE team_rank;

CREATE TABLE team_rank
(
  id serial NOT NULL, -- 排行ID
  place smallint NOT NULL, -- 名次
  team_id integer NOT NULL, -- 球队ID
  turn smallint NOT NULL, -- 已进行轮次
  win smallint NOT NULL, -- 胜场
  even smallint NOT NULL, -- 平局
  lost smallint NOT NULL, -- 负场
  goal smallint NOT NULL, -- 总进球数
  lost_goal smallint NOT NULL, -- 总失球数
  net_goal smallint NOT NULL, -- 净胜球数
  point smallint NOT NULL, -- 积分
  CONSTRAINT "Team_Rank_pkey" PRIMARY KEY (id),
  CONSTRAINT "Team_Rank_Team_ID_fkey" FOREIGN KEY (team_id)
      REFERENCES team (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE team_rank
  OWNER TO postgres;
COMMENT ON TABLE team_rank
  IS '球队排行榜';
COMMENT ON COLUMN team_rank.id IS '排行ID';
COMMENT ON COLUMN team_rank.place IS '名次';
COMMENT ON COLUMN team_rank.team_id IS '球队ID';
COMMENT ON COLUMN team_rank.turn IS '已进行轮次';
COMMENT ON COLUMN team_rank.win IS '胜场';
COMMENT ON COLUMN team_rank.even IS '平局';
COMMENT ON COLUMN team_rank.lost IS '负场';
COMMENT ON COLUMN team_rank.goal IS '总进球数';
COMMENT ON COLUMN team_rank.lost_goal IS '总失球数';
COMMENT ON COLUMN team_rank.net_goal IS '净胜球数';
COMMENT ON COLUMN team_rank.point IS '积分';

GRANT SELECT(id), REFERENCES(id) ON team_rank TO public;
GRANT SELECT(net_goal), REFERENCES(net_goal) ON team_rank TO public;


-- Trigger: calc_net_goal on team_rank

-- DROP TRIGGER calc_net_goal ON team_rank;

CREATE TRIGGER calc_net_goal
  AFTER INSERT OR UPDATE OF goal, lost_goal
  ON team_rank
  FOR EACH ROW
  EXECUTE PROCEDURE team_rank_calc_net_goal_trigger();
COMMENT ON TRIGGER calc_net_goal ON team_rank IS '计算净胜球数';








-- Table: player_rank

-- DROP TABLE player_rank;

CREATE TABLE player_rank
(
  id serial NOT NULL, -- 球员排行ID
  place smallint NOT NULL, -- 名次
  player_id integer NOT NULL, -- 球员ID
  goal smallint NOT NULL, -- 进球数
  CONSTRAINT "Player_Rank_pkey" PRIMARY KEY (id),
  CONSTRAINT "Player_Rank_Player_ID_fkey" FOREIGN KEY (player_id)
      REFERENCES player (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE player_rank
  OWNER TO postgres;
COMMENT ON TABLE player_rank
  IS '球员进球榜';
COMMENT ON COLUMN player_rank.id IS '球员排行ID';
COMMENT ON COLUMN player_rank.place IS '名次';
COMMENT ON COLUMN player_rank.player_id IS '球员ID';
COMMENT ON COLUMN player_rank.goal IS '进球数';

GRANT SELECT(id), REFERENCES(id) ON player_rank TO public;



-- Table: admin

-- DROP TABLE admin;

CREATE TABLE admin
(
  id serial NOT NULL, -- 管理员ID
  username character varying(32) NOT NULL, -- 管理员帐户
  password character(32) NOT NULL, -- 密码md5
  CONSTRAINT admin_pkey PRIMARY KEY (id),
  CONSTRAINT admin_username_key UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE admin
  OWNER TO postgres;
COMMENT ON TABLE admin
  IS '管理员';
COMMENT ON COLUMN admin.id IS '管理员ID';
COMMENT ON COLUMN admin.username IS '管理员帐户';
COMMENT ON COLUMN admin.password IS '密码md5';



  