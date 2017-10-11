<!DOCTYPE html>
<html>
  <head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-bs/css/dataTables.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-buttons-bs/css/buttons.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-responsive-bs/css/responsive.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-scroller-bs/css/scroller.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/bootstrap-multiselect/css/bootstrap-multiselect.css') }}" rel="stylesheet">
  
  </head>
  
  <body>
      <select id="column-visible" multiple="multiple">                        
                            <option id="no" value="0">Number</option>
                            <option id="name" value="1">Name</option>
                            <option id="email" value="2">Email</option>
                            <option id="auth" value="3">Authentication</option>
                            <option id="active" value="4">Activation</option>
                            <option id="del" value="5">Delete</option>
                            <option id="create" value="6">Create</option>
                            <option id="action" value="7">Action</option>   					
						</select>
  
    <div class="container">
      <br />
      <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-6">
          <div class="row"><!--  -->
            <form action="{{url('items/import')}}" method="post" enctype="multipart/form-data">
              <div class="col-md-6">
                {{csrf_field()}}
                <input type="file" name="imported-file"/>
              </div>
              <div class="col-md-6">
                  <button class="btn btn-primary" type="submit">Import</button>
              </div>
            </form>
          </div>
        </div>
        <div class="col-md-2"><!--  -->
          <form action="{{url('items/export')}}" enctype="multipart/form-data">
            <button class="btn btn-success" type="submit">Export</button>
          </form>
        </div>
      </div>
      <div class="row">
        @if(count($items))
  	    <table id="datatable-test" class="display" cellspacing="0" width="100%">
          <thead>
            <tr>
        <td>sender</td>
        <td>receiver</td>
        <td>po_number</td>
        <td>release_number</td>
        <td>po_date</td>
        <td>terms_info</td>
        <td>fob_info</td>
        <td>ship_to_name</td>
        <td>ship_to_address1</td>
        <td>ship_to_address2</td>
        <td>ship_to_location</td>
        <td>ship_to_city</td>
        <td>ship_to_state</td>
        <td>ship_to_postal</td>
        <td>ship_to_country</td>
        <td>ship_to_contact</td>
        <td>bill_to_name</td>
        <td>bill_to_address1</td>
        <td>bill_to_address2</td>
        <td>bill_to_location</td>
        <td>bill_to_city</td>
        <td>bill_to_state</td>
        <td>bill_to_postal</td>
        <td>bill_to_country</td>
        <td>bill_to_contact</td>
        <td>hdr_user_defined_field1</td>
        <td>hdr_user_defined_field2</td>
        <td>hdr_user_defined_field3</td>
        <td>hdr_user_defined_field4</td>
        <td>hdr_user_defined_field5</td>
        <td>hdr_user_defined_field6</td>
        <td>hdr_user_defined_field7</td>
        <td>hdr_user_defined_field8</td>
        <td>hdr_user_defined_field9</td>
        <td>hdr_user_defined_field10</td>
        <td>hdr_user_defined_field11</td>
        <td>hdr_user_defined_field12</td>
        <td>hdr_user_defined_field13</td>
        <td>hdr_user_defined_field14</td>
        <td>hdr_user_defined_field15</td>
        <td>hdr_user_defined_field16</td>
        <td>hdr_user_defined_field17</td>
        <td>hdr_user_defined_field18</td>
        <td>hdr_user_defined_field19</td>
        <td>hdr_user_defined_field20</td>
        <td>notes</td>
        <td>line_nbr</td>
        <td>supplier_item_nbr</td>
        <td>item_description</td>
        <td>quantity</td>
        <td>unit_price</td>
        <td>uom_basis_of_uom</td>
        <td>buyer_item_nbr</td>
        <td>manufacturer_item_nbr</td>
        <td>dtl_user_defined_field1</td>
        <td>dtl_user_defined_field2</td>
        <td>dtl_user_defined_field3</td>
        <td>dtl_user_defined_field4</td>
        <td>dtl_user_defined_field5</td>
        <td>dtl_user_defined_field6</td>
        <td>dtl_user_defined_field7</td>
        <td>dtl_user_defined_field8</td>
        <td>dtl_user_defined_field9</td>
        <td>dtl_user_defined_field10</td>
        <td>dtl_user_defined_field11</td>
        <td>dtl_user_defined_field12</td>
        <td>dtl_user_defined_field13</td>
        <td>dtl_user_defined_field14</td>
        <td>dtl_user_defined_field15</td>
        <td>dtl_user_defined_field16</td>
        <td>dtl_user_defined_field17</td>
        <td>dtl_user_defined_field18</td>
        <td>dtl_user_defined_field19</td>
        <td>dtl_user_defined_field20</td>
        <td>po_purpose</td>
        <td>sac_info</td>
        <td>delivery_date_requested</td>
        <td>last_delivery_date_requested</td>
        <td>sub_line_item</td>
        <td>item_info</td>
        
            </tr>
          </thead>
          @foreach($items as $item)
            <tr>
    
    		    <td>{{$item->sender}}</td>
            <td>{{$item->receiver}}</td>
            <td>{{$item->po_number}}</td>
            <td>{{$item->release_number}}</td>
            <td>{{$item->po_date}}</td>
            <td>{{$item->terms_info}}</td>
            <td>{{$item->fob_info}}</td>
            <td>{{$item->ship_to_name}}</td>
            <td>{{$item->ship_to_address1}}</td>
            <td>{{$item->ship_to_address2}}</td>
            <td>{{$item->ship_to_location}}</td>
            <td>{{$item->ship_to_city}}</td>
            <td>{{$item->ship_to_state}}</td>
            <td>{{$item->ship_to_postal}}</td>
            <td>{{$item->ship_to_country}}</td>
            <td>{{$item->ship_to_contact}}</td>
            <td>{{$item->bill_to_name}}</td>
            <td>{{$item->bill_to_address1}}</td>
            <td>{{$item->bill_to_address2}}</td>
            <td>{{$item->bill_to_location}}</td>
            <td>{{$item->bill_to_city}}</td>
            <td>{{$item->bill_to_state}}</td>
            <td>{{$item->bill_to_postal}}</td>
            <td>{{$item->bill_to_country}}</td>
            <td>{{$item->bill_to_contact}}</td>
            <td>{{$item->hdr_user_defined_field1}}</td>
            <td>{{$item->hdr_user_defined_field2}}</td>
            <td>{{$item->hdr_user_defined_field3}}</td>
            <td>{{$item->hdr_user_defined_field4}}</td>
            <td>{{$item->hdr_user_defined_field5}}</td>
            <td>{{$item->hdr_user_defined_field6}}</td>
            <td>{{$item->hdr_user_defined_field7}}</td>
            <td>{{$item->hdr_user_defined_field8}}</td>
            <td>{{$item->hdr_user_defined_field9}}</td>
            <td>{{$item->hdr_user_defined_field10}}</td>
            <td>{{$item->hdr_user_defined_field11}}</td>
            <td>{{$item->hdr_user_defined_field12}}</td>
            <td>{{$item->hdr_user_defined_field13}}</td>
            <td>{{$item->hdr_user_defined_field14}}</td>
            <td>{{$item->hdr_user_defined_field15}}</td>
            <td>{{$item->hdr_user_defined_field16}}</td>
            <td>{{$item->hdr_user_defined_field17}}</td>
            <td>{{$item->hdr_user_defined_field18}}</td>
            <td>{{$item->hdr_user_defined_field19}}</td>
            <td>{{$item->hdr_user_defined_field20}}</td>
            <td>{{$item->notes}}</td>
            <td>{{$item->line_nbr}}</td>
            <td>{{$item->supplier_item_nbr}}</td>
            <td>{{$item->item_description}}</td>
            <td>{{$item->quantity}}</td>
            <td>{{$item->unit_price}}</td>
            <td>{{$item->uom_basis_of_uom}}</td>
            <td>{{$item->buyer_item_nbr}}</td>
            <td>{{$item->manufacturer_item_nbr}}</td>
            <td>{{$item->dtl_user_defined_field1}}</td>
            <td>{{$item->dtl_user_defined_field2}}</td>
            <td>{{$item->dtl_user_defined_field3}}</td>
            <td>{{$item->dtl_user_defined_field4}}</td>
            <td>{{$item->dtl_user_defined_field5}}</td>
            <td>{{$item->dtl_user_defined_field6}}</td>
            <td>{{$item->dtl_user_defined_field7}}</td>
            <td>{{$item->dtl_user_defined_field8}}</td>
            <td>{{$item->dtl_user_defined_field9}}</td>
            <td>{{$item->dtl_user_defined_field10}}</td>
            <td>{{$item->dtl_user_defined_field11}}</td>
            <td>{{$item->dtl_user_defined_field12}}</td>
            <td>{{$item->dtl_user_defined_field13}}</td>
            <td>{{$item->dtl_user_defined_field14}}</td>
            <td>{{$item->dtl_user_defined_field15}}</td>
            <td>{{$item->dtl_user_defined_field16}}</td>
            <td>{{$item->dtl_user_defined_field17}}</td>
            <td>{{$item->dtl_user_defined_field18}}</td>
            <td>{{$item->dtl_user_defined_field19}}</td>
            <td>{{$item->dtl_user_defined_field20}}</td>
            <td>{{$item->po_purpose}}</td>
            <td>{{$item->sac_info}}</td>
            <td>{{$item->delivery_date_requested}}</td>
            <td>{{$item->last_delivery_date_requested}}</td>
            <td>{{$item->sub_line_item}}</td>
            <td>{{$item->item_info}}</td>            
        </tr>
          @endforeach
        </table>        
        @endif
      </div>
    </div>
  	  
  <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  	  
<!--   <script src="{{ asset('vendor/datatables.net/js/jquery.dataTables.min.js') }}"></script> -->
  <script src="{{ asset('vendor/datatables.net/js/fnFindCellRowIndexes.js') }}"></script>
  <script src="{{ asset('vendor/datatables.net-bs/js/dataTables.bootstrap.min.js') }}"></script>
         
  <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.buttons.min.js') }}"></script>
  <script src="{{ asset('vendor/datatables.net-buttons-bs/js/buttons.bootstrap.min.js') }}"></script>
  <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.flash.min.js') }}"></script>
    
  <script src="{{ asset('vendor/datatables.net-buttons/js/jszip.min.js') }}"></script>   
    
  <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.colReorder.min.js') }}"></script>   
  <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.colResize.js') }}"></script>   
    
  <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.html5.min.js') }}"></script>
  <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.print.min.js') }}"></script>
    
  <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.colvis.min.js') }}"></script>
  <script src="{{ asset('vendor/bootstrap-multiselect/js/bootstrap-multiselect.js') }}"></script>

  <script src="{{ asset('vendor/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js') }}"></script>
  <script src="{{ asset('vendor/datatables.net-keytable/js/dataTables.keyTable.min.js') }}"></script>
  <script src="{{ asset('vendor/datatables.net-responsive/js/dataTables.responsive.min.js') }}"></script>
  <script src="{{ asset('vendor/datatables.net-responsive-bs/js/responsive.bootstrap.js') }}"></script>
  <script src="{{ asset('vendor/datatables.net-scroller/js/dataTables.scroller.min.js') }}"></script>
  <script src="{{ asset('js/views/admin/setting-index-list.js') }}"></script>
  </body>
</html>
