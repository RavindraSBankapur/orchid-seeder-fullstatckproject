import React,{Component} from 'react';

class DropdownField extends Component{
    render(){
        return(
            <div className="dropDownField">
                <select name="selectedField">
                    <option>0</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
            </div>
        );
    }
}
export default DropdownField;