/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Umeng, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.simple.eventbus.test;

import junit.framework.TestCase;

import org.simple.eventbus.EventType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mrsimple
 */
public class EventTypeTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * 检测EventType作为map的key的唯一性
     */
    public void testKeysInMap() {
        Map<EventType, String> map = new HashMap<EventType, String>();
        String tag = "default";
        for (int i = 0; i < 10; i++) {
            map.put(new EventType(String.class, tag), tag + i);
        }

        assertEquals(1, map.size());
        assertEquals("default9", map.get(new EventType(String.class, "default")));
    }

    /**
     * 检测类型相同,tag不同的EventType的唯一性
     */
    public void testDiffKeysInMap() {
        Map<EventType, String> map = new HashMap<EventType, String>();
        String tag = "default";
        for (int i = 0; i < 10; i++) {
            map.put(new EventType(String.class, tag + i), tag + i);
        }

        assertEquals(10, map.size());
    }

    /**
     * 检测类型相同,tag不同的EventType的唯一性
     */
    public void testDiffParamKeysInMap() {
        Map<EventType, String> map = new HashMap<EventType, String>();
        map.put(new EventType(String.class), "String");
        map.put(new EventType(String.class, "my_tag_1"), "String");

        map.put(new EventType(Object.class), "Object");
        map.put(new EventType(Object.class, "my_tag_2"), "Object");

        map.put(new EventType(Boolean.class), "Boolean");
        map.put(new EventType(Boolean.class, "my_tag_3"), "Boolean");

        assertEquals(6, map.size());
    }
}
