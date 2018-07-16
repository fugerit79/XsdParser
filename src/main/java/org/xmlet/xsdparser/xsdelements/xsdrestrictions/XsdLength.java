package org.xmlet.xsdparser.xsdelements.xsdrestrictions;

import org.w3c.dom.Node;
import org.xmlet.xsdparser.xsdelements.XsdAbstractElement;
import org.xmlet.xsdparser.xsdelements.elementswrapper.ReferenceBase;
import org.xmlet.xsdparser.xsdelements.visitors.XsdAbstractElementVisitor;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * States the exact number of length to a given type, either a String, a List, or another measurable type. The value is
 * defined as an Integer.
 */
public class XsdLength extends XsdIntegerRestrictions {

    public static final String XSD_TAG = "xsd:length";
    public static final String XS_TAG = "xs:length";

    private XsdLength(@NotNull Map<String, String> elementFieldsMapParam) {
        super(elementFieldsMapParam);
    }

    @Override
    public void accept(XsdAbstractElementVisitor xsdAbstractElementVisitor) {
        super.accept(xsdAbstractElementVisitor);
        xsdAbstractElementVisitor.visit(this);
    }

    public static ReferenceBase parse(Node node){
        return ReferenceBase.createFromXsd(new XsdLength(XsdAbstractElement.convertNodeMap(node.getAttributes())));
    }
}