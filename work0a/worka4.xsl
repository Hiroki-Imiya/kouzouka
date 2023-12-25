<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xslt">
<xsl:output method="xml" encoding="UTF-8" indent="yes" xalan:indent-amount="2" />
<xsl:template match="/">
    <books>
        <xsl:apply-templates select="books"/>
    </books>
</xsl:template>
<xsl:template match="books">
    <xsl:apply-templates select="book"/>
    <average><xsl:value-of select="(sum(book/price) div count(book))"/></average>
</xsl:template>
<xsl:template match="book">
    <book>
        <title><xsl:value-of select="title"/></title>
        <price><xsl:value-of select="price"/></price>
    </book>
</xsl:template>
</xsl:stylesheet>