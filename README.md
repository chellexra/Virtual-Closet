# Virtual-Closet

**Virtual-Closet** is a Java desktop application that allows users to create virtual outfit combinations and save them into a personal virtual wardrobe to view later.

## 🧥 Features

- Users can load or define clothing items (tops, bottoms, shoes, accessories, etc).
- Combine items into outfit combinations (e.g., “Casual Friday”, “Formal Evening”, “Streetwear”).
- Save and store outfit combinations in the virtual closet for later viewing.
- Browse through saved outfits and modify or delete them as desired.
- Simple and intuitive UI (Java-based) for managing your wardrobe and outfit ideas.

## 🛠️ Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher installed.
- (Optional) An IDE such as IntelliJ IDEA, Eclipse or VS Code configured for Java.
- Git for cloning the repo.

### Installation / Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/chellexra/Virtual-Closet.git
   cd Virtual-Closet

Open the project in your Java IDE or compile from the command line:

javac -d bin src/**/*.java


Run the application:

java -cp bin com.yourpackage.Main


Usage

Launch the application and enter your wardrobe items (you may add images, names, categories).

Create a new outfit: select items from your wardrobe, name the outfit, and save it.

View your saved outfits in the “Closet” section, edit or remove them as needed.

Experiment with different combinations to plan outfits ahead of time.

📁 Project Structure

src/ – Java source code files.

bin/ – Compiled .class files (if you compile manually).

resources/ – Any assets (images, icons) used in the UI.

README.md – This documentation file.

.gitignore – Files/folders to exclude from version control.

✅ Why this project?

This application is a great tool for managing your wardrobe digitally and planning your outfits in advance. It also serves as a practical Java application project to demonstrate:

Object-oriented programming (classes for clothing items, outfits, wardrobe).

Basic GUI development (if using Swing/JavaFX).

File I/O for saving/loading user data.

Data structures for managing collections of items and outfits.

🔧 Future Enhancements

Some possible improvements:

Add image-uploading for each clothing item (if not already present).

Enable tagging / filtering of items (e.g., by color, season, occasion).

Implement persistent storage (e.g., using SQLite, JSON, or XML) so that wardrobe data persists across sessions.

Add a drag-and-drop interface for outfit creation.

Provide export/share functionality for outfits (e.g., share on social media or export to PDF).

Integrate fashion-recommendation logic (based on weather, event type, or user style preferences).

📄 License

This project is currently unlicensed. Feel free to add a license (e.g., MIT, Apache 2.0) if you’d like others to contribute or reuse the code.

Thank you for checking out Virtual-Closet! Feel free to contribute or open issues if you have ideas or find bugs.
