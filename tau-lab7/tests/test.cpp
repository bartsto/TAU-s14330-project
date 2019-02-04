#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "../include/teamDatabase.h"

class TeamDatabaseInh : public TeamDatabase {
  public:
    void setDatabase(std::map<size_t, Team> _database) {
        teamStorage = _database;
    };

	std::map<size_t, Team> getDatabase() {
        return teamStorage;
    };
};

TEST_CASE("Database tests - getting teams","[testDatabase][crud][getAll]") {

	SECTION("Database creation.") {
        REQUIRE_NOTHROW([]() {TeamDatabase testDatabase; return testDatabase; }());
    }

    SECTION("Database - getAll() on empty database should return empty list of teams.") {
		TeamDatabase testDatabase;

		std::list<Team> resultList = testDatabase.getAll();

        REQUIRE(resultList.size() == 0);
    }

	SECTION("Database - getAll() should return all teams.") {
        TeamDatabaseInh testDatabase;

        std::map<size_t, Team> expectedMap = {
        	{0, Team("TeamTestOne", 5000)},
        	{1, Team("TeamTestTwo", 10000)},
        	{2, Team("TeamTestThree", 20000)}
        };

        testDatabase.setDatabase(expectedMap);

        std::list<Team> expectedList;

        for (auto u : expectedMap) {
            expectedList.push_back(u.second);
        }

        REQUIRE(testDatabase.getAll() == expectedList);
    }

}

SCENARIO("Database tests - other operations", "[testDatabase][crud]") {
	using namespace Catch::Matchers;
	GIVEN("The database is available with mocked data") {
        TeamDatabaseInh testDatabase;
        std::map<size_t, Team> testDatabaseStorage = {
        	{1, Team("TestTeam1", 5000)},
        	{2, Team("TestTeam2", 10000)}
		};

        testDatabase.setDatabase(testDatabaseStorage);

        std::list<Team> testList;

        for (auto u : testDatabase.getDatabase()) {
			testList.push_back(u.second);
		}

        CHECK(testDatabase.getAll() == testList);

        WHEN("Team was added to database") {
            REQUIRE_NOTHROW(testDatabase.addTeam({"TestTeam3", 3}));
            THEN("the database should contain TestTeam3") {
                testList.push_back({"TestTeam3", 3});
                CHECK(testDatabase.getAll() == testList);
            }
        }

        WHEN("One element was removed") {
            REQUIRE_NOTHROW(testDatabase.eraseTeam(1));
            THEN("the database should contain TestTeam3") {
                testList.pop_front();
                CHECK(testDatabase.getAll() == testList);
            }
        }

        WHEN("We try to remove team which is not in database") {
            THEN("exception should be thrown") {
                REQUIRE_THROWS_AS(testDatabase.eraseTeam(100), std::out_of_range);
            }
            THEN("exception should contain correct text") {
				REQUIRE_THROWS_WITH(testDatabase.eraseTeam(100),
                     EndsWith( "not found" ) ||  StartsWith( "team" ));
            }
        }

		WHEN("We try to remove existing team") {
        	testList.pop_front();
            THEN("no exception should be thrown during removal") {
                REQUIRE_NOTHROW(testDatabase.eraseTeam(1));
            }

            THEN("database should not contain team we just removed") {
            	testDatabase.eraseTeam(1);
				CHECK(testDatabase.getAll() == testList);
            }
        }
    }
}
