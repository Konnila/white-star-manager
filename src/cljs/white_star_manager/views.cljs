(ns white-star-manager.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [white-star-manager.subs :as subs]
   ))


;; home

(defn navbar [] 
  [:nav.navbar.navbar-default 
    [:div.container-fluid
      [:div.collapse.navbar-collapse 
       []]]])
 

(defn home-title []
  (let [name (re-frame/subscribe [::subs/name])]
    [re-com/title
     :label "Whitestar manager"
     :level :level1]))

(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :children [[navbar]]])


;; about

(defn about-title []
  [re-com/title
   :label "This is the About Page."
   :level :level1])

(defn link-to-home-page []
  [re-com/hyperlink-href
   :label "go to Home Page"
   :href "#/"])

(defn about-panel []
  [re-com/v-box
   :gap "1em"
   :children [[about-title]
              [link-to-home-page]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [re-com/v-box
     :height "100%"
     :children [[panels @active-panel]]]))
