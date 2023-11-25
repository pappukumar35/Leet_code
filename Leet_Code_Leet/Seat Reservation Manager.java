class SeatManager {
    private PriorityQueue<Integer> seats; // Declare a priority queue to manage seat reservations.

    // Constructor to initialize the SeatManager with 'n' seats.
    public SeatManager(int n) {
        seats = new PriorityQueue<>();
        // Initialize the priority queue with seat numbers from 1 to 'n'.
        for (int i = 1; i <= n; i++) {
            seats.offer(i);
        }
    }

    // Reserve a seat.
    public int reserve() {
        if (!seats.isEmpty()) { // Check if there are available seats in the priority queue.
            int reservedSeat = seats.poll(); // Get the smallest seat number from the queue.
            return reservedSeat; // Return the reserved seat number.
        } else {
            return -1; // Return -1 to indicate that there are no available seats.
        }
    }

    // Unreserve a seat.
    public void unreserve(int seatNumber) {
        seats.offer(seatNumber); // Add the unreserved seat back to the priority queue.
    }
}