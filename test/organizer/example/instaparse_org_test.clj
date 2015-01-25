(ns organizer.example.instaparse-org-test
  (:require [organizer.example.instaparse-org :refer :all]
            [clojure.test :refer :all]))


(deftest org-parser-test
  (is (= (org-parse-string "* Hallo")
         [:org [:heading [:title "Hallo"]]]))

  (is (= (org-parse-string "* Welt")
         [:org [:heading [:title "Welt"]]]))

  (is (= (org-parse-string "*      Welt")
         [:org [:heading [:title "Welt"]]]))

  (is (= (org-parse-string "**** Welt")
         [:org [:heading [:title "Welt"]]]))

  (is (= (org-parse-string "* Hallo\n*Welt\n")
         [:org
          [:heading [:title "Hallo"]]
          [:heading [:title "Welt"]]])))
