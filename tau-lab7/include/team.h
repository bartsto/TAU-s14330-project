#pragma once
#include <string>

class Team {
	private:
		size_t teamId, teamStadiumCapacity;
		
		std::string teamName;
		
	protected:

	public:
		Team();
		Team(std::string, size_t);
		Team(std::string, size_t, size_t);

		size_t getId() const;
		size_t getStadiumCapacity() const;

		std::string getName() const;
		void setName(std::string);

		bool operator==(const Team&) const;
};
