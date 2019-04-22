package br.com.gx2.funcoes;

public class OSValidator {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static int sistema() {

        if (isWindows()) {
            return 0;
        } else if (isMac()) {
            return 1;
        } else if (isUnix()) {
            return 2;
        } else {
            return 3;
        }
    }

    private static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    private static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    private static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    }


    public static void definindoDriver() {
        int os = sistema();
        String webdriverChrome = "webdriver.chrome.driver";
        String webdriverFireFox = "webdriver.gecko.driver";
        switch (os){
            case 0:
                System.setProperty(webdriverFireFox,"src/test/resources/drivers/geckodriver.exe");
                break;
            case 1:
                System.setProperty(webdriverFireFox,"src/test/resources/drivers/geckodriver");
                break;
            case 2:
                //System.setProperty(webdriverStart,"src/test/resources/drivers/unix/geckodriver");
                break;
            default:
                System.out.println("Sistema não compativel como script, favor verificar lista de compatibilidades/n"
                        + "e alterar codigo na linha 45");
        }
    }
}
