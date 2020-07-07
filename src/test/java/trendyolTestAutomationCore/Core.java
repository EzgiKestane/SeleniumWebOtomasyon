package trendyolTestAutomationCore;

public class Core {
    public static void main(String[] args) {
        PageControl trendyolPageControl = new PageControl("https://www.trendyol.com/");
        trendyolPageControl.openPage();
        trendyolPageControl.despose();

    }
}
