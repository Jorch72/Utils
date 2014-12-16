package me.planetguy.lib.util.transformations;

import java.util.Arrays;

import net.minecraftforge.common.util.ForgeDirection;
import me.planetguy.remaininmotion.BlockRecord;
import me.planetguy.remaininmotion.Directions;

public class Rotator {
	
	public static int[] rotateBlock(int px, int py, int pz, ForgeDirection axis, int yourX, int yourY, int yourZ) {
		Matrix coordsMatrixNew=new Matrix(new double[][] {
				{yourX-px},
				{yourY-py},
				{yourZ-pz}});
		Matrix rotation=Matrices.ccwRotMatrices[axis.ordinal()];
		Matrix newCoords=rotation.crossProduct(coordsMatrixNew);
		return new int[] {
				(int) (newCoords.matrix[0][0]+px),
				(int) (newCoords.matrix[1][0]+py),
				(int) (newCoords.matrix[2][0]+pz)
		};
	}
	
	private static int[][] sideMap=new int[][] {
		{0,1,3,4,5,2},
		{0,1,5,2,3,4},
	};
	
	public static int newSide(int side, int axis) {
		return sideMap[axis][side];
	}
	
	public static int newSide(int side, ForgeDirection axis) {
		return newSide(side, axis.ordinal());
	}
	
}
