package org.simon.sockets;

public class Synchro {
	private static Synchro obj;
	private Synchro() {
		
	}
public static Synchro getSynchro() {
	if (obj != null) {
		return obj;
	} else {
		obj = new Synchro();
		return obj;
	}
}
}
