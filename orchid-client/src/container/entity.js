import React, {Component} from 'react';
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css'

class Entity extends Component{   
    render(){
        return(
            <div className="entity form">
            <h2>Add/Edit Resource</h2>
            <form onSubmit="">
            <table>     
                <tr>
                    <label>Resource Type</label> <Dropdown  options={options} onChange={this._onSelect} value={defaultOption} placeholder="Select an option" />
                </tr>
                <tr>
                    <td><label>Field Name </label><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <label>Description</label><br/>
                    <textarea />
                </tr>
                <tr>
                    <input type="radio" name="inputBox"/><label>Input Box</label>
                    <input type="radio" name="textArea"/><label>Text Area</label>
                    <input type="radio" name="radio"/><label>Radio</label>
                </tr>
                    <input type="radio" name="checkbox"/><label>Checkbox</label>
                    <input type="radio" name="dropDown"/><label>Dropdown</label>
                <tr>
                    <label>UI Type Options</label>
                    <input type="text" name=""/>
                </tr>
                <tr>
                   <input type="submit" value="Add More"/>
                   <input type="submit" value="+"/>
                   <input type="submit" value="-"/>
                </tr>
                    <input type="submit" value="Submit"/>
            </table>
            </form>
        </div>          
        );
    }
}
const options = ['Tickets','Bookings'];

const defaultOption = options[0];
export default Entity;