<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xslt">
<xsl:output method="xml" encoding="UTF-8" indent="yes" xalan:indent-amount="2" />
<xsl:template match="/">
    <books>
        <xsl:apply-templates select="books/book"/>
    </books>
</xsl:template>
<xsl:template match="book">
    <book>
        <xsl:value-of select="price"/>円の「<xsl:value-of select="title"/>」は
        <xsl:choose>
            <xsl:when test="price &gt; 3000">
                高い
            </xsl:when>
            <xsl:otherwise>
                安い
            </xsl:otherwise>
        </xsl:choose></book>
</xsl:template>
</xsl:stylesheet>