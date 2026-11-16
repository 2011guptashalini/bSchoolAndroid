import { describe, expect, it } from "vitest";
import { TestDriver } from "testdriverai/vitest/hooks";

describe("Swag Labs E2E Sample Flow", () => {
  it("should log in and add an item to the shopping cart", async (context) => {
    const testdriver = TestDriver(context);

    await testdriver.provision.chrome({ url: "https://www.saucedemo.com" });

    const usernameInput = await testdriver.find("Username input field");
    await usernameInput.click();
    await testdriver.type("standard_user");

    const passwordInput = await testdriver.find("Password input field");
    await passwordInput.click();
    await testdriver.type("secret_sauce");

    const loginButton = await testdriver.find("Login button");
    await loginButton.click();

    const productPageAssert = await testdriver.assert("The Products page header and inventory items are visible");
    expect(productPageAssert).toBeTruthy();

    const addToCartButton = await testdriver.find("Add to cart button for Sauce Labs Backpack");
    await addToCartButton.click();

    const cartIcon = await testdriver.find("Shopping cart icon in the top right header");
    await cartIcon.click();

    const cartAssert = await testdriver.assert("The cart page displays Sauce Labs Backpack and Checkout button");
    expect(cartAssert).toBeTruthy();
  });
});
