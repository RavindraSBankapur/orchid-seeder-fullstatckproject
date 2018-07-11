import React,{Component} from 'react';
import {BrowserRouter as Router, Route, Link, Switch} from 'react-router-dom';
class RouterComponent extends Component{
    render(){
        return(
            <div>
                <Router>
                    <Route>
                        <Link to='/'>Home</Link>
                        <Link to='/'>About</Link>       
                    </Route>  
                </Router>
            </div>
        );
    }
}
export default RouterComponent;