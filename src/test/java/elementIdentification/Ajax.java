package elementIdentification;

public class Ajax {

    /**
     * In Selenium, AJAX calls are asynchronous requests made by a web page to a server in the background,
     * allowing parts of the page to update dynamically without a full page reload.
     *
     * The primary method for handling AJAX calls in Selenium is using Explicit Waits.
     *
     *
     * How to Handle AJAX Calls in Selenium -----------------
     * The key to handling AJAX calls is to implement synchronisation using explicit waits,
     * ensuring Selenium pauses until a specific condition related to the AJAX operation is met.
     *
     *
     * 1. Use Explicit Waits
     *
     * 2. Use JavaScript Executor
     *
     *      For heavy jQuery sites, use  driver.execute_script("return jQuery.active == 0")
     *      to verify that all active AJAX requests are complete before proceeding.
     *
     *  3. Use Implicit Waits
     *
     *  4. Monitor Network Activity
     *
     */
}
