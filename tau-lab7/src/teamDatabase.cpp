#include "teamDatabase.h"

TeamDatabase::TeamDatabase() : teamIdCounter(0) {}

std::list<Team> TeamDatabase::getAll() {
	std::list<Team> listOfTeams;

    for(auto t : teamStorage) {
		listOfTeams.push_back(u.second);
	}

	return listOfTeams;
}

void TeamDatabase::addTeam(Team _new) {
	teamStorage[_new.getId()] = _new;
}

Team TeamDatabase::getTeam(size_t _id) {
	if (teamStorage.count(_id) == 0) {
		throw std::out_of_range("Team was not found");
	}

	return teamStorage.at(_id);
}

void TeamDatabase::eraseTeam(size_t _id) {

	if (teamStorage.count(_id) == 0) {
		throw std::out_of_range("Team was not found");
	}

	teamStorage.erase(_id);
}
