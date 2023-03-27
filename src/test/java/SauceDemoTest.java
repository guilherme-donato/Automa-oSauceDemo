


	import org.junit.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.*;
	import java.util.concurrent.TimeUnit;

	public class SauceDemoTest {

	    private WebDriver driver;

	    @Before
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
/*
 * @Autor Guilherme Donato
 */
	    @Test
	    public void testSauceDemo() {
	        // Abre o site https://www.saucedemo.com/
	        driver.get("https://www.saucedemo.com/");

	        // Efetua o login com o usuário standard_user e senha secret_sauce
	        WebElement username = driver.findElement(By.id("user-name"));
	        username.sendKeys("standard_user");
	        WebElement password = driver.findElement(By.id("password"));
	        password.sendKeys("secret_sauce");
	        WebElement loginButton = driver.findElement(By.id("login-button"));
	        loginButton.click();

	        // Filtra os produtos por preço, do menor para o maior
	        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
	        sortDropdown.click();
	        WebElement priceLowToHigh = driver.findElement(By.cssSelector("option[value='lohi']"));
	        priceLowToHigh.click();

	        // Adiciona o produto "Sauce Labs Onesie" ao carrinho
	        WebElement addButton = driver.findElement(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory[data-test='add-to-cart-sauce-labs-onesie'][id='add-to-cart-sauce-labs-onesie'][name='add-to-cart-sauce-labs-onesie']"));
	        addButton.click();
	        WebElement cartButton = driver.findElement(By.className("shopping_cart_container"));
	        cartButton.click();

	        // Vai para a página "Swag Labs"
	        WebElement cartButton1 = driver.findElement(By.cssSelector("a.shopping_cart_link"));
	        cartButton1.click();

	        // Faz o checkout do carrinho
	        WebElement checkoutButton = driver.findElement(By.cssSelector(".btn_action.checkout_button"));
	        checkoutButton.click();

	        // Preenche o formulário de checkout
	        WebElement firstName = driver.findElement(By.id("first-name"));
	        firstName.sendKeys("Guilherme");
	        WebElement lastName = driver.findElement(By.id("last-name"));
	        lastName.sendKeys("Donato");
	        WebElement zipCode = driver.findElement(By.id("postal-code"));
	        zipCode.sendKeys("28940000");
	        WebElement continueButton2 = driver.findElement(By.cssSelector(".btn_primary.cart_button"));
	        continueButton2.click();
	        WebElement finishButton = driver.findElement(By.cssSelector(".btn_action.cart_button"));
	        finishButton.click();

	        // Valida a mensagem de agradecimento
	        WebElement thankYouMessage = driver.findElement(By.cssSelector(".complete-header"));
	        String messageText = thankYouMessage.getText();
	        Assert.assertEquals("Thank you for your order!", messageText);
	    }

	    @After
	    public void tearDown() {
	        driver.quit();
	    }
	}


