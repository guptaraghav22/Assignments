const initialState=[]

export const reducer =(state=initialState,action)=>{
    console.warn(action.data);
    switch(action.type){
        case "save":
            return [
                ...state,
                action.data
            ]
        default:
            return state    

    }

}