<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xslt">
<xsl:output method="xml" encoding="UTF-8" indent="yes" xalan:indent-amount="2" />
<xsl:template match="/">
    <文書>
        <xsl:apply-templates select="books"/>
    </文書>
</xsl:template>
<xsl:template match="books">
    <ブックリスト>
        <xsl:apply-templates select="book"/>
    </ブックリスト>
</xsl:template>
<xsl:template match="book">
    <本>
    <xsl:value-of select="."/>
    </本>
</xsl:template>
</xsl:stylesheet>