Projet : Modélisation de Grand Prix F1 (Java)
Équipe : Mathis, Colin et Yannis

Présentation globale
Ce projet modélise un système de gestion de Grand Prix de Formule 1 en orienté objet. Il gère les interactions entre les écuries, le personnel, les voitures et le déroulement du week-end sur un circuit.

État d'avancement des classes (Environ 80%)


Personne (100%) : Classe mère terminée, attributs et constructeur en place.
Vehicule (100%) : Classe abstraite terminée avec la gestion de l'état du moteur et les constantes physiques.

Circuit (90%) : Création fonctionnelle. À faire : ajouter des variables dynamiques comme la météo ou le nombre de virages.
Pilote & Technicien (90%) : Héritage propre, méthodes d'affichage ok. À faire : implémenter un compteur de points pour le championnat.
VehiculeAssistance (90%) : Instanciation ok. À faire : relier son déploiement aux incidents gérés par le Grand Prix.

Formule (85%) : Lien avec le pilote et type de gommes ok. À faire : rajouter une variable d'usure des pneus qui baisse à chaque tour.
Ecurie (85%) : Logique métier validée (blocage à 4 pilotes et 2 voitures max). À faire : ajouter le total des points au championnat constructeur.

Main (80%) : Fichier de test complet pour vérifier l'architecture. À faire : le transformer en vrai menu utilisateur.
GrandPrix (60%) : Structure, listes et agrégations terminées. À faire (le plus gros morceau) : coder le cœur de la simulation dans les méthodes demarrerCourse, deployerSafetyCar et afficherClassement.



Objectifs pour la suite du projet


Intégration des fichiers de données :
Créer un système de lecture de fichiers (texte ou CSV) pour charger automatiquement le calendrier de la saison, les 10 écuries et les 20 pilotes au démarrage, au lieu de tout écrire en dur dans le code.

Moteur de simulation :
Coder la logique de la course tour par tour. Les temps de chaque secteur seront calculés avec une part d'aléatoire, pondérée par les statistiques de la Formule 1 et le niveau du pilote.

Gestion des stands :
Automatiser les arrêts aux stands (pit stops) quand la variable d'usure des pneus d'une voiture devient trop critique.

Interface console :
Créer un menu interactif demandant à l'utilisateur ce qu'il veut faire (ex: Tapez 1 pour voir les écuries, Tapez 2 pour lancer le Grand Prix de Monaco, etc.).