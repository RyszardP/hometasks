package hardcore.test;


import hardcore.model.TempMailoPageModel;
import hardcore.pages.TempMailoPage;
import hardcore.service.TempMailoPageCreator;


public class TempMailoTest extends CommonConditions {

  //  @Test
    public void tempMailoOpen() {
        TempMailoPageModel tempMailoPageModel = TempMailoPageCreator.withResultFromProperty();
        TempMailoPage tempMailoPage = new TempMailoPage(driver)
                .openPage()
                .clickToHelloMessage()
                .findHello();
    }
}
