package ictgradschool.web.lab10.utilities;

/**
 * A simple helper class that deals with repetitive HTML strings
 */
public class HtmlHelper {
    /**
     * Get boilerplate HTML preamble content, from the doctype declaration to the opening body tag
     *
     * @param pageTitle The text you want to appear in the title of the document
     * @return A complete HTML preamble string
     */
    public static String getHtmlPagePreamble(String pageTitle) {
        return getHtmlPagePreamble(pageTitle, null);
    }

    /**
     * Get boilerplate HTML preamble content, from the doctype declaration to the opening body tag
     *
     * @param pageTitle The text you want to appear in the title of the document
     * @param extraHeader Any extra content you wish to add to the end of the head element
     * @return A complete HTML preamble string
     */
    public static String getHtmlPagePreamble(String pageTitle, String extraHeader) {
        StringBuilder out = new StringBuilder();

        out.append("<!DOCTYPE html>");
        out.append("<html lang=\"en\">");
        out.append("<head>");
        out.append("<meta charset=\"UTF-8\">");
        out.append("<title>");
        out.append(pageTitle);
        out.append("</title>");

        // Only add extra header content if it has content
        if (extraHeader != null && !(extraHeader.trim().isEmpty())) {
            out.append(extraHeader);
        }

        out.append("</head>");
        out.append("<body>");

        return out.toString();
    }

    /**
     * Get boilerplate HTML footer content from the close body tag to the end of the document
     *
     * @return A complete HTML footer string
     */
    public static String getHtmlPageFooter() {
        return "</body></html>";
    }

    /* TODO: Add your own helper methods! Look for places where you are repeating yourself and
       create methods that generate your HTML for you */
}
