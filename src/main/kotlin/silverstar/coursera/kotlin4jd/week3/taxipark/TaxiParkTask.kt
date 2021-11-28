package silverstar.coursera.kotlin4jd.week3.taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers.filter { driver -> this.trips.none { trip -> trip.driver == driver } }.toSet()
// this.allDrivers.minus(this.trips.map { it.driver }.toSet())

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    this.allPassengers
        .filter { p -> this.trips.count { t -> p in t.passengers } >= minTrips }
        .toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    this.allPassengers
        .filter { p -> this.trips.count { t -> t.driver == driver && p in t.passengers } > 1 }
        .toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val (tripsWithDiscount, tripsWithoutDiscount) = this.trips.partition { it.discount != null }

    return this.allPassengers
        .filter { p ->
            tripsWithDiscount.count { p in it.passengers } >
                tripsWithoutDiscount.count { p in it.passengers }
        }
        .toSet()

    //    fun discountForMajorityTrips(passenger: Passenger): Boolean {
    //        val allPassengerTrips = this.trips.filter { t -> passenger in t.passengers }
    //        val discountedCount = allPassengerTrips.count { it.discount != null }
    //        return discountedCount > allPassengerTrips.size / 2
    //    }
    //
    //
    //    return this.allPassengers.filter { discountForMajorityTrips(it) }.toSet()
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    val tripBucketCount = this.trips.map { t -> t.duration / 10 }.groupingBy { it }.eachCount()
    val mostFrequentBucket = tripBucketCount.maxByOrNull { it.value }?.key
    val rangeStart = mostFrequentBucket?.times(10)
    return rangeStart?.until(rangeStart.plus(10))
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean =
    if (this.trips.isEmpty()) {
        false
    } else {
        val incomePerDriver =
            this.allDrivers.associateWith { driver ->
                this.trips.filter { trip -> trip.driver == driver }.sumOf(Trip::cost)
            }
        val incomesSorted = incomePerDriver.values.sortedDescending()
        val totalIncome = incomesSorted.sum()
        val income20PercentDrivers = incomesSorted.take(incomesSorted.size / 5).sum()
        income20PercentDrivers >= 0.8 * totalIncome
    }
