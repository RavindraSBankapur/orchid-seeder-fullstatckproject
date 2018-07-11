import React, {Component} from 'react';
import './../styles/container.css';
import Resources from './../container/resources';
import Entity from './../container/entity';

class Container extends Component{
    render(){
        return(
            <div className="full-width-container">
                    <div className="row">
                        <div className="col-md-3">
                            <Resources />
                        </div>
                        <div className="col-md-9">
                            <Entity />
                        </div>
                    </div>   
            </div>          
        );
    }
}
export default Container;