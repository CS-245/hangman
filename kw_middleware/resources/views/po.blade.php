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
    <link href="  https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet">
  
  </head>
  
  <body>
  <button id="reset" class="btn btn-success">
  Reset
  </button>
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
        <td>po_number</td>
        <td>po_date</td>
        <td>po_purpose</td>
            </tr>
          </thead>
          @foreach($items as $item)
            <tr>    
            <td>{{$item->po_number}}</td>
            <td>{{$item->po_date}}</td>
            <td>{{$item->po_purpose}}</td>
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
