/*
 * Copyright 2001 (C) MetaStuff, Ltd. All Rights Reserved.
 * 
 * This software is open source. 
 * See the bottom of this file for the licence.
 * 
 * $Id$
 */

package org.dom4j.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.dom4j.Attribute;
import org.dom4j.CDATA;
import org.dom4j.CharacterData;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.ProcessingInstruction;
import org.dom4j.Text;
import org.dom4j.tree.DefaultElement;

import org.xml.sax.Attributes;

/** <p><code>UserDataElement</code> support the adornment of a user 
  * data object on an Element or Attribute instance such that the 
  * methods {@link #getData} {@link #setData(Object)}
  * will get and set the values of a user data object.
  * This can be useful for developers wishing to create XML trees and
  * adorn the trees with user defined objects.</p>
  *
  * @author <a href="mailto:james.strachan@metastuff.com">James Strachan</a>
  * @version $Revision$
  */
public class UserDataElement extends DefaultElement {

    /** The user data object */
    private Object data;

    
    public UserDataElement(String name) { 
        super(name);
    }

    public UserDataElement(QName qname) { 
        super(qname);
    }
        
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }    
    
    public String toString() {
        return super.toString() + " userData: " + data;
    }
    
    public Object clone() {
        UserDataElement answer = (UserDataElement) super.clone();
        if ( answer != this ) {
            answer.data = getCopyOfUserData();
        }
        return answer;
    }

    // Implementation methods
    //-------------------------------------------------------------------------    
    
    /** If a deep copy of user data is required whenever the clone() or createCopy()
      * methods are called on this element then this method should return a clone 
      * of the user data
      */
    protected Object getCopyOfUserData() {
        return data;            
    }

    protected Element createElement(String name) {
        Element answer = getDocumentFactory().createElement(name);
        answer.setData( getCopyOfUserData() );
        return answer;
    }
    
    protected Element createElement(QName qName) {
        Element answer = getDocumentFactory().createElement(qName);
        answer.setData( getCopyOfUserData() );
        return answer;
    }    
}




/*
 * Redistribution and use of this software and associated documentation
 * ("Software"), with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * 1. Redistributions of source code must retain copyright
 *    statements and notices.  Redistributions must also contain a
 *    copy of this document.
 *
 * 2. Redistributions in binary form must reproduce the
 *    above copyright notice, this list of conditions and the
 *    following disclaimer in the documentation and/or other
 *    materials provided with the distribution.
 *
 * 3. The name "DOM4J" must not be used to endorse or promote
 *    products derived from this Software without prior written
 *    permission of MetaStuff, Ltd.  For written permission,
 *    please contact dom4j-info@metastuff.com.
 *
 * 4. Products derived from this Software may not be called "DOM4J"
 *    nor may "DOM4J" appear in their names without prior written
 *    permission of MetaStuff, Ltd. DOM4J is a registered
 *    trademark of MetaStuff, Ltd.
 *
 * 5. Due credit should be given to the DOM4J Project
 *    (http://dom4j.org/).
 *
 * THIS SOFTWARE IS PROVIDED BY METASTUFF, LTD. AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 * METASTUFF, LTD. OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Copyright 2001 (C) MetaStuff, Ltd. All Rights Reserved.
 *
 * $Id$
 */
