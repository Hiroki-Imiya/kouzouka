<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xslt">
<xsl:output method="xml" encoding="UTF-8" indent="yes" xalan:indent-amount="2" />
<xsl:template match="/">
    <html>
        <body>
            <table>
                <xsl:attribute name="border">2</xsl:attribute>
                <xsl:attribute name="cellpadding">2</xsl:attribute>
                <tr>
                    <th>ISBN</th>
                    <th>書名</th>
                    <th>著者</th>
                    <th>表紙</th>
                </tr>
                <xsl:apply-templates select="books/book"/>
            </table>
        </body>
    </html>
</xsl:template>
<xsl:template match="book">
    <tr>
        <td><xsl:value-of select="@isbn"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="author"/></td>
        <td><xsl:element name="img">
            <xsl:attribute name="src"><xsl:value-of select="cover"></xsl:value-of></xsl:attribute>
        </xsl:element></td>
    </tr>
</xsl:template>
</xsl:stylesheet>