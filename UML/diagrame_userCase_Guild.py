from diagrams import Diagram, Cluster
from diagrams.custom import Custom
from diagrams.onprem.client import User
from diagrams.onprem.client import Users
from diagrams.onprem.database import PostgreSQL
from diagrams.programming.language import Python
from diagrams.generic.compute import Rack
from diagrams.onprem.queue import RabbitMQ
from diagrams.programming.flowchart import StartEnd, Action, Decision
from graphviz import Digraph
from diagrams.custom import Custom

graph_attrs={
    "splines": "curved" #fleche incurvé
}
node_attrs={
    "labelloc": "c", #localisation du texte
    "fixedsize": "false" #la taille des noeuds ne sont pas fixe
}

# Diagramme des cas d'utilisation
def diagramme_cas_utilisation():
    with Diagram("Diagramme de cas d'utilisation de la guilde", show=True, graph_attr=graph_attrs):
        guilde = Users("Guilde")
        aventuriers = Users("Aventuriers")
        guerrier = User("Guerrier")
        clerc = User("Clerc")
        mage = User("Mage")
        

        with Cluster("Guilde des héros"):
            reunis = StartEnd("Réunire", **node_attrs)
            communication = StartEnd("Systeme de communication", **node_attrs)
            # consultation = Custom("Consultation", "data")
            # mise_a_jour = Custom("Mise à jour", "update")
            # impression = RabbitMQ("Impression")

        # utilisateur >> auth >> consultation >> journal
        # ingenieur >> auth >> mise_a_jour >> gestion_personnel >> journal
        # mise_a_jour >> impression
        # consultation >> impression
        # impression >> directeur
        guilde >> reunis
        guilde >> communication

# def diagramme_activites():
#     with Diagram("Diagramme d'activités", show=True):
#         utilisateur = User("Utilisateur")
#         auth_legere = Python("Authentification légère")
#         auth_profonde = Python("Authentification approfondie")
#         operation = Custom("Opérations", "process")
#         consultation = Custom("Consultation produit", "data")
#         mise_a_jour = Custom("Mise à jour produit", "update")
#         journal = Rack("Journalisation")

#         utilisateur >> auth_legere >> consultation >> journal
#         utilisateur >> auth_profonde >> mise_a_jour >> journal

# def diagramme_sequences():
#     with Diagram("Diagramme de séquences", show=True):
#         utilisateur = User("Utilisateur")
#         gestion_personnel = PostgreSQL("Système de gestion personnel")
#         journal = Rack("Journalisation")
#         auth = Python("Authentification")
#         operation = Custom("Opération", "process")

#         utilisateur >> auth >> operation
#         operation >> gestion_personnel
#         operation >> journal

diagramme_cas_utilisation()
# diagramme_activites()
# diagramme_sequences()
