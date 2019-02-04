#pragma once
#include <stdexcept>
#include "team.h"
#include <map>
#include <list>

class TeamDatabase {
	private:

	protected:
		size_t teamIdCounter;

		std::map<size_t, Team> teamStorage;


	public:
		TeamDatabase();
		std::list<Team> getAll();

		Team getTeam(size_t);

		void addTeam(Team);
		void eraseTeam(size_t);

};
