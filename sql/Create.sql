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








-- Table: "Course"

-- DROP TABLE "Course";

CREATE TABLE "Course"
(
  "ID" serial NOT NULL, -- 比赛ID
  "Home_ID" smallint NOT NULL, -- 主场球队ID
  "Away_ID" smallint NOT NULL, -- 客场球队ID
  "Turn" smallint NOT NULL, -- 比赛轮次
  "Match_Date" timestamp with time zone NOT NULL, -- 比赛日期
  "Home_Score" smallint NOT NULL, -- 主队比分
  "Away_Score" smallint NOT NULL, -- 客队比分
  CONSTRAINT "Course_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Course_Away_ID_fkey" FOREIGN KEY ("Away_ID")
      REFERENCES team (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Course_Home_ID_fkey" FOREIGN KEY ("Home_ID")
      REFERENCES team (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Course"
  OWNER TO postgres;
COMMENT ON TABLE "Course"
  IS '比赛进程表';
COMMENT ON COLUMN "Course"."ID" IS '比赛ID';
COMMENT ON COLUMN "Course"."Home_ID" IS '主场球队ID';
COMMENT ON COLUMN "Course"."Away_ID" IS '客场球队ID';
COMMENT ON COLUMN "Course"."Turn" IS '比赛轮次';
COMMENT ON COLUMN "Course"."Match_Date" IS '比赛日期';
COMMENT ON COLUMN "Course"."Home_Score" IS '主队比分';
COMMENT ON COLUMN "Course"."Away_Score" IS '客队比分';

GRANT SELECT("ID"), REFERENCES("ID") ON "Course" TO public;







-- Table: "Goal"

-- DROP TABLE "Goal";

CREATE TABLE "Goal"
(
  "ID" serial NOT NULL, -- 进球ID
  "Course_ID" integer NOT NULL, -- 比赛ID
  "Player_ID" integer NOT NULL, -- 球员ID
  "Goal_Time" timestamp with time zone NOT NULL, -- 进球时间
  CONSTRAINT "Goal_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Goal_Course_ID_fkey" FOREIGN KEY ("Course_ID")
      REFERENCES "Course" ("ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Goal_Player_ID_fkey" FOREIGN KEY ("Player_ID")
      REFERENCES player (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Goal"
  OWNER TO postgres;
COMMENT ON TABLE "Goal"
  IS '进球表';
COMMENT ON COLUMN "Goal"."ID" IS '进球ID';
COMMENT ON COLUMN "Goal"."Course_ID" IS '比赛ID';
COMMENT ON COLUMN "Goal"."Player_ID" IS '球员ID';
COMMENT ON COLUMN "Goal"."Goal_Time" IS '进球时间';

GRANT SELECT("ID"), REFERENCES("ID") ON "Goal" TO public;





-- Table: "Team_Rank"

-- DROP TABLE "Team_Rank";

CREATE TABLE "Team_Rank"
(
  "ID" serial NOT NULL, -- 排行ID
  "Place" smallint NOT NULL, -- 名次
  "Team_ID" integer NOT NULL, -- 球队ID
  "Turn" smallint NOT NULL, -- 已进行轮次
  "Win" smallint NOT NULL, -- 胜场
  "Even" smallint NOT NULL, -- 平局
  "Lost" smallint NOT NULL, -- 负场
  "Goal" smallint NOT NULL, -- 总进球数
  "Lost_Goal" smallint NOT NULL, -- 总失球数
  "Net_Goal" smallint NOT NULL, -- 净胜球数
  "Point" smallint NOT NULL, -- 积分
  CONSTRAINT "Team_Rank_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Team_Rank_Team_ID_fkey" FOREIGN KEY ("Team_ID")
      REFERENCES team (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Team_Rank"
  OWNER TO postgres;
COMMENT ON TABLE "Team_Rank"
  IS '球队排行榜';
COMMENT ON COLUMN "Team_Rank"."ID" IS '排行ID';
COMMENT ON COLUMN "Team_Rank"."Place" IS '名次';
COMMENT ON COLUMN "Team_Rank"."Team_ID" IS '球队ID';
COMMENT ON COLUMN "Team_Rank"."Turn" IS '已进行轮次';
COMMENT ON COLUMN "Team_Rank"."Win" IS '胜场';
COMMENT ON COLUMN "Team_Rank"."Even" IS '平局';
COMMENT ON COLUMN "Team_Rank"."Lost" IS '负场';
COMMENT ON COLUMN "Team_Rank"."Goal" IS '总进球数';
COMMENT ON COLUMN "Team_Rank"."Lost_Goal" IS '总失球数';
COMMENT ON COLUMN "Team_Rank"."Net_Goal" IS '净胜球数';
COMMENT ON COLUMN "Team_Rank"."Point" IS '积分';

GRANT SELECT("ID"), REFERENCES("ID") ON "Team_Rank" TO public;
GRANT SELECT("Net_Goal"), REFERENCES("Net_Goal") ON "Team_Rank" TO public;


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




-- Trigger: calc_net_goal on "Team_Rank"

-- DROP TRIGGER calc_net_goal ON "Team_Rank";

CREATE TRIGGER calc_net_goal
  AFTER INSERT OR UPDATE OF "Goal", "Lost_Goal"
  ON "Team_Rank"
  FOR EACH ROW
  EXECUTE PROCEDURE team_rank_calc_net_goal_trigger();
COMMENT ON TRIGGER calc_net_goal ON "Team_Rank" IS '计算净胜球数';






-- Table: "Player_Rank"

-- DROP TABLE "Player_Rank";

CREATE TABLE "Player_Rank"
(
  "ID" serial NOT NULL, -- 球员排行ID
  "Place" smallint NOT NULL, -- 名次
  "Player_ID" integer NOT NULL, -- 球员ID
  "Goal" smallint NOT NULL, -- 进球数
  CONSTRAINT "Player_Rank_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Player_Rank_Player_ID_fkey" FOREIGN KEY ("Player_ID")
      REFERENCES player (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Player_Rank"
  OWNER TO postgres;
COMMENT ON TABLE "Player_Rank"
  IS '球员进球榜';
COMMENT ON COLUMN "Player_Rank"."ID" IS '球员排行ID';
COMMENT ON COLUMN "Player_Rank"."Place" IS '名次';
COMMENT ON COLUMN "Player_Rank"."Player_ID" IS '球员ID';
COMMENT ON COLUMN "Player_Rank"."Goal" IS '进球数';

GRANT SELECT("ID"), REFERENCES("ID") ON "Player_Rank" TO public;

  