(ns altmtrk.core-test
  (:require [clojure.test :refer :all]
            [speclj.core :refer :all]
            [altmtrk.core :refer :all]))

(describe "1 is neither prime nor composite"
  (it "is-prime 1 is false"
    (should-not ( is-prime 1))))

(describe "2 is prime  "
  (it "is-prime 2 is true"
    (should ( is-prime 2))))

(describe "3 is prime"
  (it "is-prime 3 is true"
    (should ( is-prime 3    ))))

(describe "4 is composite"
  (it "is-prime 4 is false"
    (should-not ( is-prime 4 ))))

(describe "first-n-primes should return a list of n  numbers"
  (it "first-n-primes should return a list of n  numbers"
    (should (= 10 (count  (first-n-primes  10 is-prime))))))

(describe "check that the first 10 primes are correct"
  (it "first-n-primes are  return a list of n  numbers"
    (should (= '(2 3 5 7 11 13 17 19 23 25) (first-n-primes  10 is-prime)))))

(describe "check that make-table handles invalid inputs"
  (it "make-table  should throw error on invalid input"
    (should (=
                "Error:java.lang.Character cannot be cast to java.lang.Number"
                (make-table \a)))))
