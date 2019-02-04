#include "team.h"

Team::Team(): teamName(""), teamId(0), teamStadiumCapacity(0) {}

Team::Team(std::string _name, size_t _id) : teamName(_name), teamId(_id), teamStadiumCapacity(0) {}

Team::Team(std::string _name, size_t _id, size_t _stadiumcapacity) : teamName(_name), teamId(_id), teamStadiumCapacity(_stadiumcapacity) {}

size_t Team::getId() const {
	return teamId;
}

size_t Team::getStadiumCapacity() const {
	return teamStadiumCapacity;
}

std::string Team::getName() const {
	return teamName;
}

void Team::setName(std::string _name) {
	teamName = _name;
}

bool Team::operator==(const Team &_team) const {
	return (
		(this->teamId == _team.teamId) &&
		(this->teamName == _team.teamName) &&
		(this->teamStadiumCapacity == _team.teamStadiumCapacity)
	);
}
