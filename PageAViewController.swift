//
//  PageAViewController.swift
//  PageApplication1
//
//  Created by Jason Robinson on 11/6/14.
//  Copyright (c) 2014 Jason Robinson. All rights reserved.
//

import UIKit

class PageAViewController: UIViewController {
    
    @IBOutlet weak var PageA: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.view.backgroundColor = UIColor.redColor()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
