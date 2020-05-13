/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 *
 * @author zeyad
 */
public class IpNetwork {
    InetAddress ipConnect;
    public boolean connect(int i)
    {   
            byte[] ip = null;
	    try {
//                 InetAddress xx = InetAddress.getLocalHost();
                  ip=GetExternalIp();
	   System.out.println("myIp: "+InetAddress.getByAddress(ip).toString());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
            try {
                ip[3] = (byte)i;
                
                
                InetAddress address = InetAddress.getByAddress(ip);
                String ipString = address.toString().substring(1);
                System.out.println("add: "+address);
                System.out.println("isReachable = " + address.isReachable(200));
                if (address.isReachable(200)) {
                    ipConnect=address;
                    System.out.println("ping successed at ip: " + ipString);
                    return true;
                } 
            } catch (IOException e) {
                    System.out.println("there is no server to be connected to");
              }             
            return false;
    }

    public static byte[] GetExternalIp()throws SocketException{
		byte[] ip=null;
		Enumeration e;
                e = NetworkInterface.getNetworkInterfaces(); 	
		NetworkInterface n = (NetworkInterface) e.nextElement();
		Enumeration en = n.getInetAddresses();
		if (en.hasMoreElements())
		{
                    InetAddress i = (InetAddress) en.nextElement();
                    i = (InetAddress) en.nextElement();
                       try{
                            ip = i.getAddress();
                        } catch (Exception ex) {
                            ex.printStackTrace();     
                        }
		}
		return ip;
    }

}
