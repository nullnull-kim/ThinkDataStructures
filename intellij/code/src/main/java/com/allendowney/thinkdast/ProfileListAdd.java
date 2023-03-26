package com.allendowney.thinkdast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jfree.data.xy.XYSeries;

import com.allendowney.thinkdast.Profiler.Timeable;

public class ProfileListAdd {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		profileArrayListAddEnd();
		/*
		4000, 1
		8000, 1
		16000, 1
		32000, 2
		64000, 3
		128000, 5
		256000, 19
		512000, 21
		1024000, 205
		2048000, 493
		4096000, 526
		8192000, 821
		16384000, 2093
		Estimated slope= 1.230218124257888
		 */
//		profileArrayListAddBeginning();
		/*
		4000, 8
		8000, 27
		16000, 125
		32000, 499
		64000, 1899
		128000, 7618
		256000, 31567
		Estimated slope= 2.0015802379545753
		 */
//		profileLinkedListAddBeginning();
		/*
		4000, 2
		8000, 2
		16000, 1
		32000, 3
		64000, 7
		128000, 11
		256000, 13
		512000, 39
		1024000, 168
		2048000, 157
		4096000, 1119
		8192000, 4388
		16384000, 10032
		Estimated slope= 1.3787323858995897
		 */
		profileLinkedListAddEnd();
		/*
		4000, 1
		8000, 0
		16000, 1
		32000, 2
		64000, 5
		128000, 10
		256000, 10
		512000, 30
		1024000, 177
		2048000, 118
		4096000, 386
		8192000, 4473
		16384000, 12888
		Estimated slope= 1.404322631969055
		 */
	}

	/**
	 * Characterize the run time of adding to the end of an ArrayList
	 */
	public static void profileArrayListAddEnd() {
		Timeable timeable = new Timeable() {
			List<String> list;

			public void setup(int n) {
				list = new ArrayList<String>();
			}

			public void timeMe(int n) {
				for (int i=0; i<n; i++) {
					list.add("a string");
				}
			}
		};
		int startN = 4000;
		int endMillis = 1000;
		runProfiler("ArrayList add end", timeable, startN, endMillis);
	}
	
	/**
	 * Characterize the run time of adding to the beginning of an ArrayList
	 */
	public static void profileArrayListAddBeginning() {
		// 모르겠
		Timeable timeable = new Timeable() {
			List<String> list;

			public void setup(int n) {
				list = new ArrayList<String>();
			}

			public void timeMe(int n) {
				for (int i=0; i<n; i++) {
					list.add(0, "a string");
				}
			}
		};
		int startN = 4000;
		int endMillis = 10000;
		runProfiler("ArrayList add beginning", timeable, startN, endMillis);
		// TODO: FILL THIS IN!
	}

	/**
	 * Characterize the run time of adding to the beginning of a LinkedList
	 */
	public static void profileLinkedListAddBeginning() {
		// TODO: FILL THIS IN!
		Timeable timeable = new Timeable() {
			List<String> list;

			public void setup(int n) {
				list = new LinkedList<>();
			}

			public void timeMe(int n) {
				for (int i=0; i<n; i++) {
					list.add(0, "a string");
				}
			}
		};
		int startN = 4000;
		int endMillis = 10000;
		runProfiler("LinkedList add beginning", timeable, startN, endMillis);
	}

	/**
	 * Characterize the run time of adding to the end of a LinkedList
	 */
	public static void profileLinkedListAddEnd() {
		// TODO: FILL THIS IN!
		Timeable timeable = new Timeable() {
			List<String> list;

			public void setup(int n) {
				list = new LinkedList<>();
			}

			public void timeMe(int n) {
				for (int i=0; i<n; i++) {
					list.add("a string");
				}
			}
		};
		int startN = 4000;
		int endMillis = 10000;
		runProfiler("LinkedList add End", timeable, startN, endMillis);
	}

	/**
	 * Runs the profiles and displays results.
	 * 
	 * @param timeable
	 * @param startN
	 * @param endMillis
	 */
	private static void runProfiler(String title, Timeable timeable, int startN, int endMillis) {
		Profiler profiler = new Profiler(title, timeable);
		XYSeries series = profiler.timingLoop(startN, endMillis);
		profiler.plotResults(series);
	}
}