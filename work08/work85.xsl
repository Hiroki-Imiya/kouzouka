<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xslt">
<xsl:output method="xml" encoding="UTF-8" indent="yes" xalan:indent-amount="2" />
<xsl:template match="/">
    <html>
        <body>
            <xsl:apply-templates select="books"/>
        </body>
    </html>
</xsl:template>
<xsl:template match="books">
    <table>
        <xsl:apply-templates select="book"/>
    </table>
</xsl:template>
<xsl:template match="book">
    <tr>
        <td><xsl:value-of select="year"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="author"/></td>
    </tr>
</xsl:template>
</xsl:stylesheet>