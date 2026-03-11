package elementIdentification;

public class LocatorStrategy {

    /**
     *
     *
     * class name :
     * Locates elements whose class name contains the search value (compound class names are not permitted)
     * Eg:  driver.findElement(By.className("class_attribute_Value"));
     *
     *
     * css selector	:
     * Locates elements matching a CSS selector
     * Eg: driver.findElement(By.cssSelector("[attribute_name = 'attribute_value']"));
     *
     *
     * id :
     * Locates elements whose ID attribute matches the search value
     * Eg: driver.findElement(By.id("id_Value"));
     *
     *
     * name :
     * Locates elements whose NAME attribute matches the search value
     * Eg: driver.findElement(By.name("name_attribute_value"));
     *
     *
     * link text :
     * Locates anchor elements whose visible text matches the search value
     * Eg: driver.findElement(By.linkText("link_label/link text"));
     *
     *
     * partial link text :
     * Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected.
     * Eg: driver.findElement(By.partialLinkText("partial/ part of link_label/link text"));
     *
     *
     * tag name :
     * Locates elements whose tag name matches the search value
     * Eg: driver.findElement(By.tagName("a"));
     *
     *
     * xpath :
     * Locates elements matching an XPath expression
     * Eg: driver.findElement(By.xpath("//*[name()='svg'][@class='gb_E']"))
     *
     *
     */
}
