package pl.edu.pjatk.tau.football;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pl.edu.pjatk.tau.football.service.TeamServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class CucumberTeamTestSteps {
    TeamServiceImpl teamServiceImpl;

    @Given("^we have empty list of teams$")
    public void we_have_empty_list_of_teams() throws Exception {
        teamServiceImpl = new TeamServiceImpl();
    }

    @Given("^we will create two teams$")
    public void we_will_create_two_teams() throws Exception {
        teamServiceImpl.create(0, "Manchester United", "Manchester", "Old Trafford");
        teamServiceImpl.create(1, "Tottenham", "Londyn", "Wembley");
    }

    @When("^we will search first team name by partial \"([^\"]*)\"$")
    public void we_will_search_first_team_name_by_partial(String arg1) throws Exception {
        teamServiceImpl.searchFirstTeamByNotFullName(arg1);
    }


    @Then("^the result should be \"([^\"]*)\"$")
    public void the_result_should_be(String arg1) throws Exception {
        Assert.assertEquals(arg1, teamServiceImpl.searchFirstTeamByNotFullName(arg1));
    }

    @Given("^we will create three teams$")
    public void we_will_create_three_teams() throws Exception {
        teamServiceImpl.create(0, "Manchester United", "Manchester", "Old Trafford");
        teamServiceImpl.create(1, "Liverpool FC", "Liverpool", "Anfield Road");
        teamServiceImpl.create(2, "Arsenal Londyn", "Arsenal", "Emirates Stadium");
    }

    @When("^we will delete teams by provided list of teams names$")
    public void we_will_run_method_with_provided_list() throws Exception {
        List<String> listOfTeamNamesToRemove = new ArrayList<>();
        listOfTeamNamesToRemove.add("Manchester United");
        listOfTeamNamesToRemove.add("Liverpool FC");

        teamServiceImpl.deleteTeamsByProvidedListOfTeamNames(listOfTeamNamesToRemove);
    }

    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(int arg1) throws Exception {
        Assert.assertEquals(arg1, teamServiceImpl.readAll().size());
    }

}
