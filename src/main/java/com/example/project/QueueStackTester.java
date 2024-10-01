package com.example.project;

public class QueueStackTester {
	public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {

		int size = q.length();
		T odd, even;

		while (size-- > 0) {
			// get odd
			odd = q.serve();
			q.enqueue(odd);

			// add odd
			if (!oq.full())
				oq.enqueue(odd);

			// check for size
			if (size-- > 0) {
				// get even
				even = q.serve();
				q.enqueue(even);

				// add even
				if (!eq.full())
					eq.enqueue(even);
			}
		}

	}

	public static <T> void remove(LinkedPQ<T> pq, int p) {

		int size = pq.length();
		LinkedPQ<T> tmp = new LinkedPQ<T>();
		PQElement<T> pqe;
		
		for (int i = 0; i < size; i++) {
			pqe = pq.serve();
			tmp.enqueue(pqe.data, pqe.p);
		}
		
		for (int i = 0; i < size; i++) {
			pqe = tmp.serve();
			if (pqe.p >= p)
				pq.enqueue(pqe.data, pqe.p);
		}

	}

	public static <T> boolean search(Stack<T> st, T e) {
		
		boolean found = false;
		T element;
		
		if (!st.empty()) {
			element = st.pop();
			if (element.equals(e))
				found = true;
			if(!found)
				found = search(st, e);
			st.push(element);
		}
		
		return found;
	}
}