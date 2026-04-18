Je sais pas si j'ai bien envoyé mon commentaire sur les modifications que j'ai fait, mais je le met ici aussi! 🤓

- AddContactScreen : J'ai majoritairement recopié le layout de EditContactScreen.

- AppNavigation : J'ai ajouté la navigation jusqu'à ContactDetailScreen.

- Color : J'ai ajouté une couleur pour faire des tests*.

- ContactDetailScreen : J'ai déplacé les infos qu'on voyait en expended de ContactListScreen pour les afficher dans ContactDetailScreen.

- ContactItem : J'ai changé le onClick sur le contact pour avoir onClick qui affiche l'extended, et onLongClick qui navige vers ContactDetailScreen. (j'aime bien l'idée de extended, donc je voulais pas totalement l'effacer).

- ContactViewModel : Le plus long... 
1. J'ai changé la liste de contact pour qu'elle soit le uiState de contacts à la place. Parce qu'on doit modifier l'état de la liste.
2. Ensuite, j'ai dû modifier les autres fonctions de la classe, pour qu'elles soient compatibles avec un uiState au lieu d'une liste.
3. Puis, j'ai enlevé la liste de contact qui était créée, pour à la place utiliser cette de DataSource.loadData().

- DataSource : J'ai rajouté 20 contacts pour faire des tests*.

- Theme : J'ai mis à false l'utilisation de dynamic color, sinon les couleurs qu'on va ajouter nous-mêmes n'apparaîtront pas.

** Tout les modifications pour faire des tests, tu peux les enlever.
** J'ai aussi fait quelques modifications mineures juste pour l'apparence, comme 
1. changer le tri avec les prénom en 1er, ensuite le nom.
2. dans contactItem: J'ai ajouté shape = RoundedCorner... pour avoir un contour rond pour chaque contact.

Mais encore une fois, tu es libre d'améliorer le code à ta façon. 🙂

Tout ce qu'il nous reste :
- Les 2 commentaires que tu as mis dans AddContactScreen ;
- Faire ContactForm.kt ;
- La mise en page des écrans ;
- Typographie, Couleur, Theme ;
- Organiser le code avec des commentaires ;
- Les photos de profil, mais je vais demander au prof si une photo par défaut nous donne les 2 pts ou non. x)
- Des animations serait cool, mais c'est pas nécessaire du tout, je pourrai le faire après les photo de profile.
- Aussi, je sais pas si tu es d'accord que je fasse une classe utilitaire parce qu'il y a plusieurs composables qui se répètent.
