package com.mingyuansoftware.aifactory.util;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BaseToString {

    public static String BaseEntityToString(Object a_oObject)
    {
        StringBuffer sb = new StringBuffer();
        try
        {
            Class t = a_oObject.getClass();
            Field[] fields = t.getDeclaredFields();

            for (int i = 0; i < fields.length; i++)
            {
                Field field = fields[i];
                field.setAccessible(true);
                sb.append("{");
                sb.append(field.getName());
                sb.append(":");

                if (field.getType() == Integer.class)
                {
                    Object oObject = field.get(a_oObject);

                    if(oObject == null)
                        //空对象
                        sb.append(oObject);
                    else
                        sb.append(Integer.valueOf(oObject.toString() ) );
                }
                else
                    sb.append(field.get(a_oObject));

                sb.append("}");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String MapToString(Map<String, String[]> a_mMap)
    {
        String l_strMap = "{";	//返回字符串

        Set<Map.Entry<String, String[]>> set = a_mMap.entrySet();
        Iterator<Map.Entry<String, String[]>> it = set.iterator();
        while (it.hasNext())
        {
            Map.Entry<String, String[]> entry = it.next();
            String [] Values = entry.getValue();	//存值集合

            for(int i = 0; i < Values.length; i++)
            {
                l_strMap += entry.getKey() + ":" + Values [i] + ";";
            }
        }

        l_strMap += "}";

        return l_strMap;
    }
}
