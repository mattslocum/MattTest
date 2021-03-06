/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class APosExpr8 extends PExpr8
{
    private TPlusOp _plusOp_;
    private PExpr10 _expr10_;

    public APosExpr8()
    {
        // Constructor
    }

    public APosExpr8(
        @SuppressWarnings("hiding") TPlusOp _plusOp_,
        @SuppressWarnings("hiding") PExpr10 _expr10_)
    {
        // Constructor
        setPlusOp(_plusOp_);

        setExpr10(_expr10_);

    }

    @Override
    public Object clone()
    {
        return new APosExpr8(
            cloneNode(this._plusOp_),
            cloneNode(this._expr10_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPosExpr8(this);
    }

    public TPlusOp getPlusOp()
    {
        return this._plusOp_;
    }

    public void setPlusOp(TPlusOp node)
    {
        if(this._plusOp_ != null)
        {
            this._plusOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plusOp_ = node;
    }

    public PExpr10 getExpr10()
    {
        return this._expr10_;
    }

    public void setExpr10(PExpr10 node)
    {
        if(this._expr10_ != null)
        {
            this._expr10_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr10_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._plusOp_)
            + toString(this._expr10_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._plusOp_ == child)
        {
            this._plusOp_ = null;
            return;
        }

        if(this._expr10_ == child)
        {
            this._expr10_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._plusOp_ == oldChild)
        {
            setPlusOp((TPlusOp) newChild);
            return;
        }

        if(this._expr10_ == oldChild)
        {
            setExpr10((PExpr10) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
