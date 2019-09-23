package com.proyecto.cubo.ImpInterface;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.proyecto.cubo.interfaces.InterfaceCubo;
import com.proyecto.cubo.modelo.Matriz;
import com.sun.javafx.collections.MappingChange.Map;

public class ImpInterfaceCubo implements InterfaceCubo {
	

	public ImpInterfaceCubo() {

	}
	
	public String ejecutarOperacion(String input) {
		
		Matriz matriz = new Matriz();
		
		String[] arreglo = input.split("\n");
		int testCase = Integer.valueOf(arreglo[0]);
		String[] defMatrix = arreglo[1].split(" ");
		int tamano= Integer.valueOf(defMatrix[0]);
		int operaciones = Integer.valueOf(defMatrix[1]);
		
		LinkedHashMap<String, String> sentencias = new LinkedHashMap<String, String>();
		
		for (int i = 2; i < arreglo.length; i++) {
			String [] duplas = arreglo[i].split(" ", 2);
			sentencias.put(duplas[0], duplas[1]);
		}
		
		return matriz.calcular(tamano, sentencias);
	}	
		
}
