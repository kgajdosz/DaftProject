package DaftTests;

import PageObjects.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import DriverManagement.TestBase;

public class DaftE2ETest extends TestBase {

@Test
public void endToEndTest() throws InterruptedException {
	//first page (only on the first run)
	PolicyCookiessPage pc = new PolicyCookiessPage();
	pc.ClickCookies();
	//Main daft page and operations on it
	DaftHomePage df = new DaftHomePage();
	df.enterSearchedLocation();

	//popup
	PopUpPage pop = new PopUpPage();
	pop.GetPopUp().click();
	//select Filter
	df = new DaftHomePage();
	df.clickFilter();

	ModalFilterPage mf = new ModalFilterPage();
	mf.GetFilterSearch().click();

	// navigates down to the searched element
	Actions actions = new Actions(driver);
	actions.moveToElement(mf.GetSearchedKeyword()).perform();
	// enter search word
	String filterWord = "garage";
	mf.enterSearchedFilterWord(filterWord);
	mf.clickShowResults();
	//Page with all results is present
	DaftFoundPage found = new DaftFoundPage();
	//numer of elements found with searched word
	int numElements = found.GetNumElementsFound();
	found.clickRandomProperty(numElements);

	SearchedPropertyPage spp = new SearchedPropertyPage();
	//check is the searched filter keyword on the page
	Assert.assertTrue(spp.isSearchWordPresent("Garage"));
}

}
