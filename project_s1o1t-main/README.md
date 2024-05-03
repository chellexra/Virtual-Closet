
# Fit In

## An application to manage your closet virtually!

### What will my application do?

<p>My application FitIn will be an application to track and save outfits from a user's own closet.<br>
This way, when a user wears an outfit they like, they can enter any piece of clothing and categorize
them by clothing type (Hats, Tops, Bottoms, Outer Layers, Shoes, Accessories).</p>

### Who will use it?

<p>Users can also add the features of their clothing to differentiate which pieces they are referring to.
Such as, colours and size of the clothing. They can sort their clothing based on what season they would
wear the outfit for along with what kind of event they would wear it for. The main users will be people
who are trying to build a capsule wardrobe and to reuse their clothing in different variations 
so they can reduce shopping habits. Typically, our users would be interested in
fashion.</p>

### Why is this project of interest of you?

<p> This project is one of interest to me because I have a passion for sustainable fashion and tend
to get lost in my own closet as I forget what outfits I wear after the seasons change. I also want a way
to organize and style my existing wardrobe without having to purchase new clothing unnecessarily. </p>


**User Stories**
- As a user, I want to be able to add combinations of a top, bottom, and/or shoes to my outfit
- As a user, I want to be able to view a list of all my outfit combinations in my virtual closet
- As a user, I want to be able to delete outfits from my virtual closet
- As a user, I want to be able to select a season that lists all the outfits that I assign to that season
- As a user, I want to be able to save my list of outfits to file (if I so choose)
- As a user, I want to be able to load my list of outfits from file (if I so choose)
- As a user, I want to be able to view my list of outfits filtered by season


# Instructions for Grader

- You can generate the first required action related to the user story "adding multiple Outfits to a Closet" by </br> 
launching main frame, clicking addOutfit, inputting all textfields, clicking submit outfit.
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by following the </br>
first round of instructions again. You can close the addOutfit window and reopen a new window to input a new outfit.
- You can locate my visual component by opening the application
- You can save the state of my application by adding an outfit by following first instruction, then clicking save on </br>
first instruction, and clicking save by clicking the file drop down.
- You can reload the state of my application by clicking load from the file menu bar, then view outfits button
- You can filter your list of outfits by season by clicking the view outfits button after loading, and selecting the </br>
season that you want to view.

## Phase 4: Task 2
Thu Apr 04 16:14:48 PDT 2024 </br>
Viewed outfits </br>
Thu Apr 04 16:14:53 PDT 2024 </br>
Added outfitmodel.Outfit@11a0e213 to Virtual Closet </br>
Thu Apr 04 16:14:53 PDT 2024 </br>
Viewed outfits </br>
Thu Apr 04 16:14:53 PDT 2024 </br>
Loaded [model.Outfit@11a0e213]from./data/virtualCloset.json

## Phase 4: Task 3
The first refactoring I would do is create an enumeration for the seasons instead of just having a string <br>
With an enumeration, I could perform type checking because it can
be easy to make mistakes with a string. Second, since there's a lot of repetition in the GUI package, specifically
in the LaunchPage class. If I were to do some more refactoring, I would create a button class, 
so I could reduce repetition, along with a frame class and a panel class since I use
all of those methods so often for the GUI.