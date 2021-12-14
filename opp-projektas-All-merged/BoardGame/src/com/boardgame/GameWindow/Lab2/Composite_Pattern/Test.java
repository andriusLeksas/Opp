package com.boardgame.GameWindow.Lab2.Composite_Pattern;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CompositeDecoration tree = new CompositeDecoration("tree");
        CompositeDecoration branch1 = new CompositeDecoration("raudoni objektai");
        branch1.Add(new Leaf("leaf1","red",1,1,1,1));
        branch1.Add(new Leaf("leaf2", "red",2,2,2,2));
        CompositeDecoration branch2 = new CompositeDecoration("geltoni objektai");
        branch2.Add(new Leaf("leaf3", "yellow",3,3,3,3));
        branch2.Add(new Leaf("leaf4", "yellow", 4, 4, 4,4));
        tree.Add(branch1);
        tree.Add(branch2);

        List<Component> test = branch1.GetChild();
        List<Component> test2 = branch2.GetChild();
        int s = test2.size()+1;
        for(int i = 1; i<s; i++)
        {
            String branch = "branch" + i;

            if (branch.equals("branch1"))
            {
                for (Component a : test)
                {
                    System.out.println(a.GetColor()+" "+ a.GetX() + " " + a.GetY() + " "+a.GetWidth() + " " + a.GetHeight() + "\n");
                }
            }
            else
            {
                for (Component b : test2)
                {
                    System.out.println(b.GetColor() + " " + b.GetX() + " " + b.GetY() + " " + b.GetWidth() + " " + b.GetHeight() + "\n");
                }
            }
        }
    }
}
