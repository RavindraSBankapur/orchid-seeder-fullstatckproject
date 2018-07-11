import React,{Component} from 'react';

class TextField extends Component{
    render(){
        return(
            <div className="text-field">
                <input type="text" name="firstName"/>
            </div>
        );
    }
}
export default TextField;
