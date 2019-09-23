package com.proyecto.cubo.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Matriz {
	
	public int[][][] crearMatriz(int n) {
		
		int[][][] matriz = new int [n][n][n];
		
//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz[i].length; j++) {
//				for (int k = 0; k < matriz[i][j].length; k++) {
//					System.out.println("Fila " + matriz[i][j][k]);
//				}
//			}
//		}
		return matriz;
	}
	
	public HashSet<int[][][]> actualizarMatriz(int[][][] matriz, int x, int y, int z, int w) {		
		HashSet<int[][][]> actualizados = new HashSet<int[][][]>();
		matriz[x][y][z]= w;
		
		actualizados.add(new int [x] [y] [z]);		
		return actualizados;
		
	}
	
	public List<int[][][]> delimitarMatriz(HashSet<int[][][]> actualizados, int x1, int x2, int y1, int y2, int z1, int z2) {
		
		List<int[][][]> indices = new ArrayList<int[][][]>();
		for (int[][][] integer : actualizados) {
			for (int i = 0; i < integer.length; i++) {
				for (int j = 0; j < integer[i].length; j++) {
					for (int k = 0; k < integer[i][j].length; k++) {
						if (i >= (x1-1) && i < (x2-1) && j >= (y1-1) && j < (y2-1) && k >= (z1-1) && k < (z2-1)) {
							indices.add(new int [i][j][k]);
						}
					}
				}
			}
			
		}		
		return indices;
		
	}
	
	public int modificar(int[][][] matriz, HashSet<int[][][]> actualizados, int x1,int x2, int y1, int y2, int z1, int z2) {
		int suma= 0;
		List<int[][][]> indices = delimitarMatriz(actualizados, x1, x2, y1, y2, z1, z2);
		
		for (int[][][] is : indices) {
			for (int x = 0; x < is.length; x++) {
				for (int y = 0; y < is[x].length; y++) {
					for (int z = 0; z < is[x][y].length; z++) {
						suma+=matriz[x][y][z];
					}
				}
			}			
		}
		
		return suma;
		
	}
	
	
	public String calcular(int n, Map<String, String> queries) {
		StringBuilder respuesta = new StringBuilder();
		HashSet<int[][][]> actualizados = new HashSet<int[][][]>();
		
		int[][][] matriz = crearMatriz(n);
		
		Iterator it = queries.keySet().iterator();		
		while (it.hasNext()) {
			String type = (String) it.next();
			String[] valor = queries.get(type).split(" ");
			
			if (type.equals("UPDATE")) {				
				actualizados = actualizarMatriz(matriz, Integer.valueOf(valor[0])-1, Integer.valueOf(valor[1])-1, Integer.valueOf(valor[2])-1, Integer.valueOf(valor[3])-1);				
				
			}else {
				respuesta.append(modificar(matriz, actualizados, Integer.valueOf(valor[0]), Integer.valueOf(valor[1]), Integer.valueOf(valor[2]), Integer.valueOf(valor[3])+1, Integer.valueOf(valor[4])+1, Integer.valueOf(valor[5])+1));
			}
			
		}		
		
		return respuesta.toString();
		
	}
	public static void main(String[] args) {
		Matriz matriz = new Matriz();
		matriz.crearMatriz(4);
	}
}
